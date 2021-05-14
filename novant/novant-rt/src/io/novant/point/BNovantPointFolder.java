//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package io.novant.point;

import javax.baja.sys.*;
import javax.baja.driver.point.*;
import com.tridium.ndriver.point.*;


import io.novant.*;
import javax.baja.nre.annotations.*;

/**
 * BNovantPointFolder
 *
 * @author   Novant LLC
 * @creation 13-May-21
 */
@NiagaraType
public class BNovantPointFolder
  extends BNPointFolder
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNovantPointFolder.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BNovantNetwork.
   * @return network as a BNovantNetwork.
   */
  public final BNovantNetwork getNovantNetwork()
  {
    return (BNovantNetwork)getNetwork();
  }

  /**
   * Get the device cast to a BNovantDevice.
   * @return device as a BNovantDevice.
   */
  public final BNovantDevice getNovantDevice()
  {
    return (BNovantDevice)getDevice();
  }

}
