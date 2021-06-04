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

  /** Parse Json and return HashMap instance. */
  public Object readVal() throws IOException
  {
    // check if we need to init reader
    if (!init)
    {
      init = true;
      this.cur  = -1;
      this.peek = in.read();
    }

    if (peek == 't') return readBool();
    if (peek == 'f') return readBool();

    if (Character.isDigit(peek)) return readNum();

    throw unexpectedChar(peek);
  }

  /** Read a 'true' or 'false value. */
  private Boolean readBool() throws IOException
  {
    if (peek == 't')
    {
      read('t');
      read('r');
      read('u');
      read('e');
      return Boolean.TRUE;
    }
    else
    {
      read('f');
      read('a');
      read('l');
      read('s');
      read('e');
      return Boolean.FALSE;
    }
  }

  /** Read a Number value. */
  private Double readNum() throws IOException
  {
    StringBuffer buf = new StringBuffer();
    while (Character.isDigit(peek)) buf.append((char)read());
    return Double.parseDouble(buf.toString());
  }

  /** Read the next char from stream. */
  private int read() throws IOException
  {
    cur  = peek;
    peek = in.read();
    return cur;
  }

  /** Read the next char from stream and validate it matches expected. */
  private int read(int expected) throws IOException
  {
    int ch = read();
    if (ch != expected) throw unexpectedChar(ch);
    return ch;
  }

  private IOException unexpectedChar(int ch)
  {
    return new IOException("Unexpected char '" + ((char)ch) + "'");
  }

  private BufferedReader in;
  private boolean init = false;
  private int cur;
  private int peek;
}