/*
 * Copyright 2021 Novant, All Rights Reserved.
 */
package io.novant.point;

import javax.baja.sys.*;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.discover.*;

@NiagaraType
public class BNovantPointDiscoveryPreferences
  extends BNDiscoveryPreferences
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNovantPointDiscoveryPreferences.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  
  public Type getDiscoveryLeafType()
  {
    return BNovantPointDiscoveryLeaf.TYPE;
  }

}
