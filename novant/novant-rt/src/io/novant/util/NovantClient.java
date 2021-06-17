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
import java.nio.charset.StandardCharsets;
import javax.net.ssl.HttpsURLConnection;

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

  /**
   * Query for point data for given device, were the return
   * value is an ArrayList of HashMap sources with 'name'
   * and 'points' ArrayList of points.
   */
  public ArrayList points(String deviceId)
    throws IOException
  {
    HashMap map = (HashMap)call("points", "device_id=" + deviceId);
    return (ArrayList)map.get("sources");
  }

  /**
   * Query for value data for given device, were the return
   * value is an ArrayList of HashMap with 'id' and 'val'
   * keys.
   */
  public ArrayList values(String deviceId)
    throws IOException
  {
    HashMap map = (HashMap)call("values", "device_id=" + deviceId);
    return (ArrayList)map.get("data");
  }

  /** Invoke a API call and return results. */
  private Object call(String endpoint, String form)
    throws IOException
  {
    HttpsURLConnection c = null;
    try
    {
      // generate auth header
      String auth = apiKey + ":";
      byte[] authBytes  = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
      String authHeader = "Basic " + new String(authBytes);

      // setup connection
      URL url = new URL("https://api.novant.io/v1/" + endpoint);
      c = (HttpsURLConnection)url.openConnection();
      c.setRequestMethod("POST");
      c.setInstanceFollowRedirects(false);
      c.setConnectTimeout(30000);  // 30sec
      c.setReadTimeout(30000);     // 30sec
      // c.setUseCaches(false);

      c.setDoOutput(true);
      c.setDoInput(true);
      c.setRequestProperty("Connection", "Close");
      c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      c.setRequestProperty("Authorization", authHeader);
      c.connect();

      // post form
      Writer w = new OutputStreamWriter(c.getOutputStream(), "UTF-8");
      w.write(form);
      w.close();

      // verify response
      if (c.getResponseCode() != 200)
        throw new IOException("" + c.getResponseCode() + ": " +c.getResponseMessage());

      // read response
      return new JsonReader(c.getInputStream()).readVal();
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