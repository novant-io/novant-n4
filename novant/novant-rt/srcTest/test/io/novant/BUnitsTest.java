//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   22 Jul 2021  Andy Frank  Creation
//

package test.io.novant;

import java.io.*;
import java.util.*;

import javax.baja.nre.annotations.*;
import javax.baja.sys.*;
import javax.baja.test.BTestNg;
import javax.baja.units.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.novant.util.*;

/** BUnitsTest */
@NiagaraType
public class BUnitsTest extends BTestNg
{

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

@Override
public Type getType() { return TYPE; }
public static final Type TYPE = Sys.loadType(BUnitsTest.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @BeforeMethod public void beforeMethod() {}
  @AfterMethod public void afterMethod() {}

  @Test public void test() throws IOException
  {
    // test existing
    verifyEq(NovantUnits.get("kW"),  BUnit.getUnit("kilowatt"));
    verifyEq(NovantUnits.get("Pa"),  BUnit.getUnit("pascal"));
    verifyEq(NovantUnits.get("N-s"), BUnit.getUnit("newton second"));

    // test make new
    verifyEq(NovantUnits.get("foo"), BUnit.make("foo", "foo", BDimension.DEFAULT));
    verifyEq(NovantUnits.get("bar"), BUnit.make("bar", "bar", BDimension.DEFAULT));
  }
}
