//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   4 Jun 2021  Andy Frank  Creation
//

package test.io.novant;

import java.io.*;
import java.util.*;

import javax.baja.nre.annotations.*;
import javax.baja.sys.*;
import javax.baja.test.BTestNg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.novant.util.*;

/** BJsonTest */
@NiagaraType
public class BJsonTest extends BTestNg
{

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

@Override
public Type getType() { return TYPE; }
public static final Type TYPE = Sys.loadType(BJsonTest.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @BeforeMethod public void beforeMethod() {}
  @AfterMethod public void afterMethod() {}

  @Test public void testBool() throws IOException
  {
    verifyEq(read("true"),  Boolean.TRUE);
    verifyEq(read("false"), Boolean.FALSE);
  }

  @Test public void testNum() throws IOException
  {
    verifyEq(read("5"),      new Double(5));
    verifyEq(read("-12"),    new Double(-12));
    verifyEq(read("10572"),  new Double(10572));
    verifyEq(read("18.4"),   new Double(18.4));
    verifyEq(read("-0.123"), new Double(-0.123));
  }

  @Test public void testStr() throws IOException
  {
    verifyEq(read("\"foo\""), "foo");
    verifyEq(read("\"this has  some   spaces\""), "this has  some   spaces");
    // TODO: is this test right???
    verifyEq(read("\"this has a \\\" quote\""),     "this has a \\\" quote");
  }

  @Test public void testMap() throws IOException
  {
    verifyEq(read("{}"), new HashMap());

    HashMap m = new HashMap();
    m.put("b", Boolean.TRUE);
    verifyEq(read("{\"b\":true}"), m);
    verifyEq(read("{ \"b\" : true }"), m);

    m.put("n", new Double(15));
    verifyEq(read("{\"b\":true,\"n\":15}"), m);
    verifyEq(read("{\"b\": true, \"n\": 15 }"), m);

    m.put("s", "foo");
    verifyEq(read("{\"b\":true,\"n\":15,\"s\":\"foo\"}"), m);
    verifyEq(read("{ \"b\":true, \"n\":15, \"s\":\"foo\" }"), m);
  }

  private Object read(String s) throws IOException
  {
    InputStream in = new ByteArrayInputStream(s.getBytes());
    JsonReader r = new JsonReader(in);
    return r.readVal();
  }
}
