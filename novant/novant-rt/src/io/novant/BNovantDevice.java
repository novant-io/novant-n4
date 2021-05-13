//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package io.novant;

import javax.baja.driver.util.BPollFrequency;
import javax.baja.status.BStatus;
import javax.baja.sys.*;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.BNDevice;
import com.tridium.ndriver.poll.BINPollable;
import com.tridium.ndriver.util.SfUtil;

import io.novant.point.*;


/**
 *  BNovantDevice models a single device
 *
 *  @author   Novant LLC
 *  @creation 13-May-21
 */
@NiagaraType
@NiagaraProperty(name = "pollFrequency", type = "BPollFrequency",  defaultValue = "BPollFrequency.normal")
@NiagaraProperty(name = "points", type = "BNovantPointDeviceExt",  defaultValue = "new BNovantPointDeviceExt()")
public class BNovantDevice
  extends BNDevice
  implements BINPollable
{

  // Add facet to include following in auto manager view
  public static final Property status = newProperty(Flags.TRANSIENT|Flags.READONLY|Flags.SUMMARY|Flags.DEFAULT_ON_CLONE, BStatus.ok, SfUtil.incl(SfUtil.MGR_EDIT_READONLY));

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Property "pollFrequency"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the <code>pollFrequency</code> property.
   * How frequently the device is polled for data
   * @see io.novant.BNovantDevice#getPollFrequency
   * @see io.novant.BNovantDevice#setPollFrequency
   */
  public static final Property pollFrequency = newProperty(0, BPollFrequency.normal,null);

  /**
   * Get the <code>pollFrequency</code> property.
   * How frequently the device is polled for data
   * @see io.novant.BNovantDevice#pollFrequency
   */
  public BPollFrequency getPollFrequency() { return (BPollFrequency)get(pollFrequency); }

  /**
   * Set the <code>pollFrequency</code> property.
   * How frequently the device is polled for data
   * @see io.novant.BNovantDevice#pollFrequency
   */
  public void setPollFrequency(BPollFrequency v) { set(pollFrequency,v,null); }

////////////////////////////////////////////////////////////////
// Property "points"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the <code>points</code> property.
   * @see io.novant.BNovantDevice#getPoints
   * @see io.novant.BNovantDevice#setPoints
   */
  public static final Property points = newProperty(0, new BNovantPointDeviceExt(),null);

  /**
   * Get the <code>points</code> property.
   * @see io.novant.BNovantDevice#points
   */
  public BNovantPointDeviceExt getPoints() { return (BNovantPointDeviceExt)get(points); }

  /**
   * Set the <code>points</code> property.
   * @see io.novant.BNovantDevice#points
   */
  public void setPoints(BNovantPointDeviceExt v) { set(points,v,null); }


////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNovantDevice.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


////////////////////////////////////////////////////////////////
// Overrides
////////////////////////////////////////////////////////////////

  /**
   * Returns the network type that the device runs on.
   * @return Type object representing the network
   */
  public Type getNetworkType() { return BNovantNetwork.TYPE; }


  /**
   * Override started
   */
  public void started()
    throws Exception
  {
    super.started();

    // register device with poll scheduler
    getNovantNetwork().getPollScheduler().subscribe(this);
  }

  /**
   * Override stopped
   */
  public void stopped()
    throws Exception
  {
    // unregister device with poll scheduler
    getNovantNetwork().getPollScheduler().unsubscribe(this);
    super.stopped();
  }


////////////////////////////////////////////////////////////////
// Implementation
////////////////////////////////////////////////////////////////
  /**
   *
   */
  public void doPing()
  {
    // TODO - add ping implementation
    // if()
      pingOk();
    // else
    //  pingFail("not receiving response from device ");
  }


////////////////////////////////////////////////////////////////
// Polling support
////////////////////////////////////////////////////////////////

  /**
   * The poll() callback method called from BPollScheduler
   * when it is time to poll this object.
   */
  public void doPoll()
  {
    // TODO add poll support
  }

////////////////////////////////////////////////////////////////
// Utilities
////////////////////////////////////////////////////////////////
  /**
   * Get the network cast to a BNovantNetwork.
   * @return network as a BNovantNetwork.
   */
  public final BNovantNetwork getNovantNetwork()
  {
    return (BNovantNetwork)getNetwork();
  }



}
