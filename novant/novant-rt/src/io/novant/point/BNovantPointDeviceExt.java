//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package io.novant.point;

import java.util.*;
import javax.baja.sys.*;
import javax.baja.nre.annotations.*;
import javax.baja.nre.util.Array;
import com.tridium.ndriver.discover.*;
import com.tridium.ndriver.point.*;

import io.novant.*;
import io.novant.util.*;

/**
 * BNovantPointDeviceExt is a container for novant proxy points.
 */
@NiagaraType
@NiagaraProperty(
  name = "discoveryPreferences",
  type = "BNovantPointDiscoveryPreferences",
  defaultValue = "new BNovantPointDiscoveryPreferences()",
  override = true
)
public class BNovantPointDeviceExt extends BNPointDeviceExt
{

  public static final Property discoveryPreferences = newProperty(Flags.HIDDEN, new BNovantPointDiscoveryPreferences(), null);

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
// BINDiscoveryHost
////////////////////////////////////////////////////////////////

  /** Call back for discoveryJob to get an array of discovery objects.
   *  Override point for driver specific discovery. */
  public BINDiscoveryObject[] getDiscoveryObjects(BNDiscoveryPreferences prefs)
    throws Exception
  {
    try
    {
      BNovantDevice dev = getNovantDevice();
      Array acc = new Array(BNovantPointDiscoveryLeaf.class);

      NovantClient c = new NovantClient(dev.getApiKeyPlainText());
      ArrayList vals = c.points(dev.getDeviceId());
      for (int i=0; i<vals.size(); i++)
      {
        HashMap src = (HashMap)vals.get(i);
        String name = (String)src.get("name");
        ArrayList pts = (ArrayList)src.get("points");

        System.out.println("#   " + name);
        for (int j=0; j<pts.size(); j++)
        {
          HashMap p = (HashMap)pts.get(j);
          System.out.println("#     - " + p.get("name"));
          acc.add(new BNovantPointDiscoveryLeaf(p));
        }
      }

      BINDiscoveryObject[] x = (BNovantPointDiscoveryLeaf[])acc.trim();
      System.out.println(x);
      return x;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
}