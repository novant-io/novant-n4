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
  public void testBJsonTest()
  {
    try
    {
      String text = "{ \"b\":true, \"n\":15, \"s\":\"foo\" }";
      InputStream in = new ByteArrayInputStream(text.getBytes());
      JsonReader json = new JsonReader(in);
      HashMap map = json.read();
      verify(map != null);
    }
    catch (Exception e) { fail(); }
  }

  @AfterMethod
  public void afterMethod() {}
}
