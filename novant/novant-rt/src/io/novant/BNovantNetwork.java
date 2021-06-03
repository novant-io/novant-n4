//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package io.novant;

import javax.baja.naming.BOrd;
import javax.baja.sys.*;
import javax.baja.util.Lexicon;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.BNNetwork;
import com.tridium.ndriver.comm.*;
import com.tridium.ndriver.comm.http.*;
import com.tridium.ndriver.datatypes.*;
import com.tridium.ndriver.discover.*;
import com.tridium.ndriver.poll.*;

import io.novant.point.*;

/**
 * BNovantNetwork models a network of Novant devices
 */
@NiagaraType
@NiagaraProperty(
  name = "pollScheduler",
  type = "BNPollScheduler",
  defaultValue = "new BNPollScheduler()")
@NiagaraProperty(
  name = "discoveryPreferences",
  type = "BNDiscoveryPreferences",
  defaultValue = "new BNovantPointDiscoveryPreferences()",
  flags = Flags.HIDDEN)
@NiagaraAction(
  name= "submitDiscoveryJob",
  parameterType = "BNDiscoveryPreferences",
  defaultValue = "new BNovantPointDiscoveryPreferences()",
  returnType = "baja:Ord",
  flags = Flags.HIDDEN)
public class BNovantNetwork
  extends BNNetwork
{

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $io.novant.BNovantNetwork(3473825091)1.0$ @*/
/* Generated Mon May 17 14:08:14 EDT 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "pollScheduler"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the {@code pollScheduler} property.
   * @see #getPollScheduler
   * @see #setPollScheduler
   */
  public static final Property pollScheduler = newProperty(0, new BNPollScheduler(), null);

  /**
   * Get the {@code pollScheduler} property.
   * @see #pollScheduler
   */
  public BNPollScheduler getPollScheduler() { return (BNPollScheduler)get(pollScheduler); }

  /**
   * Set the {@code pollScheduler} property.
   * @see #pollScheduler
   */
  public void setPollScheduler(BNPollScheduler v) { set(pollScheduler, v, null); }

////////////////////////////////////////////////////////////////
// Property "discoveryPreferences"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the {@code discoveryPreferences} property.
   * @see #getDiscoveryPreferences
   * @see #setDiscoveryPreferences
   */
  public static final Property discoveryPreferences = newProperty(Flags.HIDDEN, new BNovantPointDiscoveryPreferences(), null);

  /**
   * Get the {@code discoveryPreferences} property.
   * @see #discoveryPreferences
   */
  public BNDiscoveryPreferences getDiscoveryPreferences() { return (BNDiscoveryPreferences)get(discoveryPreferences); }

  /**
   * Set the {@code discoveryPreferences} property.
   * @see #discoveryPreferences
   */
  public void setDiscoveryPreferences(BNDiscoveryPreferences v) { set(discoveryPreferences, v, null); }

////////////////////////////////////////////////////////////////
// Action "submitDiscoveryJob"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the {@code submitDiscoveryJob} action.
   * @see #submitDiscoveryJob(BNDiscoveryPreferences parameter)
   */
  public static final Action submitDiscoveryJob = newAction(Flags.HIDDEN, new BNovantPointDiscoveryPreferences(), null);

  /**
   * Invoke the {@code submitDiscoveryJob} action.
   * @see #submitDiscoveryJob
   */
  public BOrd submitDiscoveryJob(BNDiscoveryPreferences parameter) { return (BOrd)invoke(submitDiscoveryJob, parameter, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNovantNetwork.class);

  /** Specify name for network resources. */
  public String getNetworkName() { return "NovantNetwork"; }

  /** return device folder type  */
  @Override
  public Type getDeviceFolderType()
  {
    return BNovantDeviceFolder.TYPE;
  }

  /** return device type */
  @Override
  public Type getDeviceType()
  {
    return BNovantDevice.TYPE;
  }

  @Override
  public void changed(Property p, Context cx)
  {
    super.changed(p, cx);
    if (!isRunning()) return;

    if (p == status)
    {
      // Give any comms opportunity to respond to status changes
      // getHttpConfig().statusUpdate();
    }
  }

////////////////////////////////////////////////////////////////
// Discovery
////////////////////////////////////////////////////////////////

  public BOrd doSubmitDiscoveryJob(BNDiscoveryPreferences preferences)
  {
    throw new RuntimeException("NOPE NOT YET!");
  }

////////////////////////////////////////////////////////////////
// Utilities
////////////////////////////////////////////////////////////////

  public static Lexicon LEX = Lexicon.make(BNovantNetwork.class);
}