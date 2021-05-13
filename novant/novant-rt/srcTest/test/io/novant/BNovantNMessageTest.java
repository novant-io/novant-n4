//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package test.io.novant;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.test.BTestNg;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import javax.baja.sys.*;
import javax.baja.nre.annotations.*;

/**
 *  BNovantDeviceTest is a default unit test package for an nDriver based device driver.
 *
 *  @author   Novant LLC
 *  @creation 13-May-21
 */

@NiagaraType
public class BNovantNMessageTest
  extends BTestNg
{

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

@Override
public Type getType() { return TYPE; }
public static final Type TYPE = Sys.loadType(BNovantNMessageTest.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @BeforeMethod
  public void beforeMethod()
  {

  }

  @Test
  public void testBNovantNMessageTest()
  {

  }

  @AfterMethod
  public void afterMethod()
  {

  }
}
