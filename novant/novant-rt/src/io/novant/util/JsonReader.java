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

    // eat leading whitespace
    eatWhitespace();

    // bool
    if (peek == 't') return readBool();
    if (peek == 'f') return readBool();

    // num
    if (peek == '-') return readNum();
    if (Character.isDigit(peek)) return readNum();

    // str
    if (peek == '\"') return readStr();

    // map
    if (peek == '{') return readMap();

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
    if (peek == '-') buf.append((char)read());
    while (Character.isDigit(peek) || peek == '.') buf.append((char)read());
    return Double.parseDouble(buf.toString());
  }

  /** Read a Str value. */
  private String readStr() throws IOException
  {
    StringBuffer buf = new StringBuffer();
    read('\"');
    while (peek != '\"')
    {
      // TODO: yeah fix this!
      if (peek == '\\') buf.append((char)read());
      buf.append((char)read());
    }
    read('\"');
    return buf.toString();
  }

  /** Read a HashMap value. */
  private HashMap readMap() throws IOException
  {
    HashMap map = new HashMap();
    read('{');
    while (peek != '}')
    {
      // add key:value pair
      eatWhitespace();
      String key = readStr();
      eatWhitespace();
      read(':');
      eatWhitespace();
      Object val = readVal();
      map.put(key, val);

      // verify next char is valid
      eatWhitespace();
      if (peek == ',') { read(); continue; }
      if (peek == '}') continue;
      throw unexpectedChar(peek);
    }
    read('}');
    return map;
  }

  /** Read the next char from stream. */
  private int read() throws IOException
  {
    cur  = peek;
    peek = in.read();
    pos++;
    return cur;
  }

  /** Read the next char from stream and validate it matches expected. */
  private int read(int expected) throws IOException
  {
    int ch = read();
    if (ch != expected) throw unexpectedChar(ch);
    return ch;
  }

  /** Eat leading whitespace. */
  private void eatWhitespace() throws IOException
  {
    while (peek == ' ') read();
  }

  private IOException unexpectedChar(int ch)
  {
    return new IOException("Unexpected char '" + ((char)ch) + "' [" + pos + "]");
  }

  private BufferedReader in;
  private boolean init = false;
  private int cur;
  private int peek;
  private int pos;
}