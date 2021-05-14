//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   14 May 2021  Andy Frank  Creation
//

package io.novant.util;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.net.ssl.HttpsURLConnection;
// import javax.net.ssl.SSLSocketFactory;

/**
 * NovantClient provides support for the Novant REST API.
 */
public final class NovantClient
{
  /** Constructor. */
  public NovantClient(String apiKey)
  {
    this.apiKey = apiKey;
  }

  /** Query for point data for given device. */
  public String points(String deviceId)
    throws IOException
  {
    return call("points", "device_id=" + deviceId);
  }

  /** Invoke a API call and return results. */
  private String call(String endpoint, String form)
    throws IOException
  {
    HttpsURLConnection c = null;
    try
    {
      // setup connection
      URL url = new URL("https://api.novant.io/v1/" + endpoint);
      c = (HttpsURLConnection)url.openConnection();
      c.setRequestMethod("POST");
      c.setInstanceFollowRedirects(false);
      c.setConnectTimeout(30000);  // 30sec
      c.setReadTimeout(30000);     // 30sec

      c.setDoOutput(true);
      c.setDoInput(true);
      c.setRequestProperty("Connection", "Close");
      c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      c.connect();

      // post form
      Writer w = new OutputStreamWriter(c.getOutputStream(), "UTF-8");
      w.write(form);
      w.close();

      // verify response
      if (c.getResponseCode() != 200)
        throw new IOException("" + c.getResponseCode() + ": " +c.getResponseMessage());

      // read response
      StringBuffer s = new StringBuffer(1024);
      Reader r = new BufferedReader(new InputStreamReader(c.getInputStream(), "UTF-8"));
      int n;
      while ((n = r.read()) > 0) s.append((char)n);
      return s.toString();
    }
    catch (Exception err)
    {
      throw new IOException("API call '" + endpoint + "' failed", err);
    }
    finally
    {
      try { c.disconnect(); } catch (Exception e) {}
    }
  }

  private final String apiKey;
}