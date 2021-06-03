//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package io.novant;

import java.security.*;
import javax.baja.driver.util.BPollFrequency;
import javax.baja.security.BPassword;
import javax.baja.status.BStatus;
import javax.baja.sys.*;
import javax.baja.nre.annotations.*;
import com.tridium.ndriver.BNDevice;
import com.tridium.ndriver.poll.BINPollable;
import com.tridium.ndriver.util.SfUtil;
import io.novant.point.*;
import io.novant.util.*;

/**
 * BNovantDevice models a single Novant device.
 */
@NiagaraType
@NiagaraProperty(
  name = "apiKey",
  type = "BPassword",
  defaultValue= "BPassword.DEFAULT",
  facets = { @Facet("SfUtil.incl(SfUtil.MGR_EDIT)") })
@NiagaraProperty(
  name = "deviceId",
  type = "BString",
  defaultValue = "",
  flags = Flags.SUMMARY,
  facets = { @Facet("SfUtil.incl(SfUtil.MGR_EDIT)") })
@NiagaraProperty(
  name = "pollFrequency",
  type = "BPollFrequency",
  defaultValue = "BPollFrequency.normal")
@NiagaraProperty(
  name = "points",
  type = "BNovantPointDeviceExt",
  defaultValue = "new BNovantPointDeviceExt()")
public class BNovantDevice
  extends BNDevice
  implements BINPollable
{
  // Add facet to include following in auto manager view
  public static final Property status = newProperty(Flags.TRANSIENT|Flags.READONLY|Flags.SUMMARY|Flags.DEFAULT_ON_CLONE, BStatus.ok, SfUtil.incl(SfUtil.MGR_EDIT_READONLY));

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $io.novant.BNovantDevice(4046366321)1.0$ @*/
/* Generated Fri May 14 14:18:53 EDT 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "apiKey"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the {@code apiKey} property.
   * @see #getApiKey
   * @see #setApiKey
   */
  public static final Property apiKey = newProperty(0, BPassword.DEFAULT, SfUtil.incl(SfUtil.MGR_EDIT));

  /**
   * Get the {@code apiKey} property.
   * @see #apiKey
   */
  public BPassword getApiKey() { return (BPassword)get(apiKey); }

  /**
   * Set the {@code apiKey} property.
   * @see #apiKey
   */
  public void setApiKey(BPassword v) { set(apiKey, v, null); }

////////////////////////////////////////////////////////////////
// Property "deviceId"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the {@code deviceId} property.
   * @see #getDeviceId
   * @see #setDeviceId
   */
  public static final Property deviceId = newProperty(Flags.SUMMARY, "", SfUtil.incl(SfUtil.MGR_EDIT));

  /**
   * Get the {@code deviceId} property.
   * @see #deviceId
   */
  public String getDeviceId() { return getString(deviceId); }

  /**
   * Set the {@code deviceId} property.
   * @see #deviceId
   */
  public void setDeviceId(String v) { setString(deviceId, v, null); }

////////////////////////////////////////////////////////////////
// Property "pollFrequency"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the {@code pollFrequency} property.
   * @see #getPollFrequency
   * @see #setPollFrequency
   */
  public static final Property pollFrequency = newProperty(0, BPollFrequency.normal, null);

  /**
   * Get the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public BPollFrequency getPollFrequency() { return (BPollFrequency)get(pollFrequency); }

  /**
   * Set the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public void setPollFrequency(BPollFrequency v) { set(pollFrequency, v, null); }

////////////////////////////////////////////////////////////////
// Property "points"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the {@code points} property.
   * @see #getPoints
   * @see #setPoints
   */
  public static final Property points = newProperty(0, new BNovantPointDeviceExt(), null);

  /**
   * Get the {@code points} property.
   * @see #points
   */
  public BNovantPointDeviceExt getPoints() { return (BNovantPointDeviceExt)get(points); }

  /**
   * Set the {@code points} property.
   * @see #points
   */
  public void setPoints(BNovantPointDeviceExt v) { set(points, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  @Override
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
   * Callback for ping() action.
   */
  public void doPing()
  {
    System.out.println("# NovantDevice.doPing {" + getDeviceId() + "}");
    pingOk();
    // pingFail("Ping failed blah blah");
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
    // throttle down our polls to 1min
    long now = System.nanoTime();
    if (now - lastPoll > ticks1min)
    {
      this.lastPoll = now;
      System.out.println("# NovantDevice.onPoll {" + getDeviceId() + "}");
      doUpdateVals();
    }
  }

  /** Callback to update values for points. */
  private void doUpdateVals()
  {
    try
    {
//System.out.println("### NovantClient.values {" + getDeviceId() + "}");
//    NovantClient c = new NovantClient(getApiKeyPlainText());
//    String r = c.points(getDeviceId());
//System.out.println("### " + r);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
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

  /** Get API key as plaintext. */
  public final String getApiKeyPlainText()
  {
    BPassword p = getApiKey();
    return AccessController.doPrivileged((PrivilegedAction<String>)p::getValue);
  }

////////////////////////////////////////////////////////////////
// Fields
////////////////////////////////////////////////////////////////

  private static final long ticks1min = 60000000000L;
  private static final long ticks5min = ticks1min * 5L;

  private long lastPoll = 0L;
}