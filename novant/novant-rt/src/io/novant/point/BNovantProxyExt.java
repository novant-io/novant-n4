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
import com.tridium.ndriver.util.SfUtil;
import javax.baja.nre.annotations.*;

import io.novant.*;
import com.tridium.driver.util.DrUtil;

/**
 * BNovantProxyExt
 */
@NiagaraType
@NiagaraProperty(
  name = "pointId",
  type = "BString",
  defaultValue = "",
  flags = Flags.SUMMARY,
  facets = { @Facet("SfUtil.incl(SfUtil.MGR_EDIT)") })
public class BNovantProxyExt
  extends BNProxyExt
{
  // Override ProxyExt default status to clear stale state.
  // public static final Property status = newProperty(Flags.READONLY|Flags.TRANSIENT, BStatus.ok, null);


/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $io.novant.point.BNovantProxyExt(3300338074)1.0$ @*/
/* Generated Fri Jun 04 10:27:10 EDT 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "pointId"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the {@code pointId} property.
   * @see #getPointId
   * @see #setPointId
   */
  public static final Property pointId = newProperty(Flags.SUMMARY, "", SfUtil.incl(SfUtil.MGR_EDIT));

  /**
   * Get the {@code pointId} property.
   * @see #pointId
   */
  public String getPointId() { return getString(pointId); }

  /**
   * Set the {@code pointId} property.
   * @see #pointId
   */
  public void setPointId(String v) { setString(pointId, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  @Override
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

  public void readSubscribed(Context cx) throws Exception
  {
    getBNovantDevice().subscribe(this);
  }

  public void readUnsubscribed(Context cx) throws Exception
  {
    getBNovantDevice().unsubscribe(this);
  }

  public boolean write(Context cx) throws Exception
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

  /** Update point value. */
  public void updateVal(Object val)
  {
    if (val instanceof Double)
    {
      double dval = ((Double)val).doubleValue();
      readOk(new BStatusNumeric(dval));
    }
    else
    {
      readFail("Read failed");
    }
  }
}
