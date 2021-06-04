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

  @BeforeMethod
  public void beforeMethod() {}

  @Test
  public void testBJsonTest() throws IOException
  {
    verifyEq(read("true"),  Boolean.TRUE);
    verifyEq(read("false"), Boolean.FALSE);
    verifyEq(read("5"),     new Double(5));
    verifyEq(read("10572"), new Double(10572));
    // verifyEq(read("18.4"),  18.4);
  }

  private Object read(String s) throws IOException
  {
    InputStream in = new ByteArrayInputStream(s.getBytes());
    JsonReader r = new JsonReader(in);
    return r.readVal();
  }

  @AfterMethod
  public void afterMethod() {}
}
