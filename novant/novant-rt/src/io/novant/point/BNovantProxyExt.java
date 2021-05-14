//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package io.novant.point;

import javax.baja.sys.*;
import javax.baja.status.*;
import javax.baja.driver.point.*;
import com.tridium.ndriver.point.BNProxyExt;
import javax.baja.nre.annotations.*;

import io.novant.*;
import com.tridium.driver.util.DrUtil;


/**
 * BNovantProxyExt
 *
 *  @author   Novant LLC
 * @creation 13-May-21
 */
@NiagaraType
public class BNovantProxyExt
  extends BNProxyExt
{

  // Override ProxyExt default status to clear stale state.
  // public static final Property status = newProperty(Flags.READONLY|Flags.TRANSIENT, BStatus.ok, null);

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNovantProxyExt.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BNovantNetwork.
   */
  public final BNovantNetwork getNovantNetwork()
  {
    return (BNovantNetwork)getNetwork();
  }

  /**
   * Get the device cast to a BNovantDevice.
   */
  public final BNovantDevice getBNovantDevice()
  {
    return (BNovantDevice)DrUtil.getParent(this, BNovantDevice.TYPE);
  }

  /**
   * Get the point device ext cast to a BNovantPointDeviceExt.
   */
  public final BNovantPointDeviceExt getNovantPointDeviceExt()
  {
    return (BNovantPointDeviceExt)getDeviceExt();
  }

////////////////////////////////////////////////////////////////
// ProxyExt
////////////////////////////////////////////////////////////////
  public void readSubscribed(Context cx)
    throws Exception
  {
    // TODO
  }

  public void readUnsubscribed(Context cx)
    throws Exception
  {
     // TODO
  }

  public boolean write(Context cx)
    throws Exception
  {
    // TODO
    return false;
  }

  /**
   * Return the device type.
   */
  public Type getDeviceExtType()
  {
    return BNovantPointDeviceExt.TYPE;
  }

  /**
   * Return the read/write mode of this proxy.
   */
  public BReadWriteMode getMode()
  {
    // TODO
    return BReadWriteMode.readonly;
  }

  public boolean isBoolean()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusBoolean;
  }

  public boolean isNumeric()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusNumeric;
  }

  public boolean isString()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusString;
  }

  public boolean isEnum()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusEnum;
  }

}
