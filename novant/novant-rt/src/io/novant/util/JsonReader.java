//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   14 May 2021  Andy Frank  Creation
//

package io.novant.util;

import java.io.*;
import java.util.*;

/**
 * JsonReader.
 */
public final class JsonReader
{
  /** Constructor. */
  public JsonReader(InputStream in)
  {
    this.in = new BufferedReader(new InputStreamReader(in));
  }

  /** Close underlying input stream. */
  public JsonReader close() throws IOException
  {
    in.close();
    return this;
  }

  /** Write given char to output stream. */
  public Object read() throws IOException
  {
    return "todo";
  }

  /** JsonToken models tokens read from instream */
  private final class JsonToken
  {
    public JsonToken(int id, Object val)
    {
      this.id = id;
      this.val = val;
    }

    final int id;
    final Object val;
  }

  private BufferedReader in;
}