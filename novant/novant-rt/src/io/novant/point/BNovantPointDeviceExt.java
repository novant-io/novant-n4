//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package io.novant.point;

import javax.baja.sys.*;


import com.tridium.ndriver.discover.*;
import com.tridium.ndriver.point.*;


import io.novant.*;
import javax.baja.nre.annotations.*;

/**
 * BNovantPointDeviceExt is a container for novant proxy points.
 *
 * @author   Novant LLC
 * @creation 13-May-21
 */
@NiagaraType

@NiagaraProperty(
  name = "discoveryPreferences",
  type = "BNovantPointDiscoveryPreferences",
  defaultValue = "new BNovantPointDiscoveryPreferences()",
  override = true
)

public class BNovantPointDeviceExt


  extends BNPointDeviceExt
{


/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNovantPointDeviceExt.class);

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

////////////////////////////////////////////////////////////////
// PointDeviceExt
////////////////////////////////////////////////////////////////

  /**
   * @return the Device type.
   */
  public Type getDeviceType()
  {
    return BNovantDevice.TYPE;
  }

  /**
   * @return the PointFolder type.
   */
  public Type getPointFolderType()
  {
    return BNovantPointFolder.TYPE;
  }

  /**
   * @return the ProxyExt type.
   */
  public Type getProxyExtType()
  {
    return BNovantProxyExt.TYPE;
  }


////////////////////////////////////////////////////////////////
//BINDiscoveryHost
////////////////////////////////////////////////////////////////

  /** Call back for discoveryJob to get an array of discovery objects.
   *  Override point for driver specific discovery. */
  public BINDiscoveryObject[] getDiscoveryObjects(BNDiscoveryPreferences prefs)
      throws Exception
  {
     //
     // TODO  get array of discovery objects
     //
//    Array a = new Array(??.class);
//    for(??)
//     a.add(new BNovantPointDiscoveryLeaf(??));
//    return (??[])a.trim();
    return null;
  }

}
