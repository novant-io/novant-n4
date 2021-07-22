//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   21 Jul 2021  Andy Frank  Creation
//

package io.novant.util;

import java.util.*;
import javax.baja.units.*;

/**
 * NovantUnits provides unit conversion to BUnit.
 */
public final class NovantUnits
{
  /** Lookup a BUnit by symbol, or create a new BUnit if not found. */
  public static BUnit get(String symbol)
  {
    if (map == null) loadMap();

    BUnit unit = (BUnit)map.get(symbol);
    if (unit == null)
    {
      unit = BUnit.make(symbol, symbol, BDimension.DEFAULT);
      map.put(symbol, unit);
    }

    return unit;
  }

  /** Load reverse lookup map via UnitDatabase. */
  private static void loadMap()
  {
    map = new HashMap();
    UnitDatabase.Quantity[] quants = UnitDatabase.getDefault().getQuantities();
    for (int i=0; i<quants.length; i++)
    {
      UnitDatabase.Quantity q = quants[i];
      BUnit[] units = q.getUnits();
      for (int j=0; j<units.length; j++)
      {
        BUnit u = units[j];
        map.put(u.getSymbol(), u);
      }
    }
  }

  private static HashMap map;
}