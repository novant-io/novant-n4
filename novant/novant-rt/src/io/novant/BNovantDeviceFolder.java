//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package io.novant;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.BNDeviceFolder;

/**
 * BNovantDeviceFolder is a folder for BNovantDevice.
 *
 *  @author   Novant LLC
 *  @creation 13-May-21
 */
@NiagaraType
public class BNovantDeviceFolder
  extends BNDeviceFolder
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNovantDeviceFolder.class);

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
   * @return true if parent is BNovantNetwork or BNovantDeviceFolder.
   */
  public boolean isParentLegal(BComponent parent)
  {
    return parent instanceof BNovantNetwork ||
           parent instanceof BNovantDeviceFolder;
  }


}
