//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package io.novant;

//import javax.baja.license.Feature;
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



/**
 *  BNovantNetwork models a network of devices
 *
 *  @author   Novant LLC
 *  @creation 13-May-21
 */
@NiagaraType
  @NiagaraProperty(name = "pollScheduler", type = "BNPollScheduler",  defaultValue = "new BNPollScheduler()")
  @NiagaraProperty(name = "httpConfig", type = "BHttpCommConfig",  defaultValue = "new BHttpCommConfig()")

public class BNovantNetwork
  extends BNNetwork
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
//Property "pollScheduler"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the <code>pollScheduler</code> property.
     * @see io.novant.BNovantNetwork#getPollScheduler
     * @see io.novant.BNovantNetwork#setPollScheduler
     */
    public static final Property pollScheduler = newProperty(0, new BNPollScheduler(),null);

    /**
     * Get the <code>pollScheduler</code> property.
     * @see io.novant.BNovantNetwork#pollScheduler
     */
    public BNPollScheduler getPollScheduler() { return (BNPollScheduler)get(pollScheduler); }

    /**
     * Set the <code>pollScheduler</code> property.
     * @see io.novant.BNovantNetwork#pollScheduler
     */
    public void setPollScheduler(BNPollScheduler v) { set(pollScheduler,v,null); }


  ////////////////////////////////////////////////////////////////
  // Property "httpConfig"
  ////////////////////////////////////////////////////////////////

    /**
     * Slot for the <code>httpConfig</code> property.
     * @see io.novant.BNovantNetwork#getHttpConfig
     * @see io.novant.BNovantNetwork#setHttpConfig
     */
    public static final Property httpConfig = newProperty(0, new BHttpCommConfig(),null);

    /**
     * Get the <code>httpConfig</code> property.
     * @see io.novant.BNovantNetwork#httpConfig
     */
    public BHttpCommConfig getHttpConfig() { return (BHttpCommConfig)get(httpConfig); }

    /**
     * Set the <code>httpConfig</code> property.
     * @see io.novant.BNovantNetwork#httpConfig
     */
    public void setHttpConfig(BHttpCommConfig v) { set(httpConfig,v,null); }



  ////////////////////////////////////////////////////////////////
  // Type
  ////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNovantNetwork.class);

  /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/





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

  /** TODO - Add license check if needed
  @Override
  public final Feature getLicenseFeature()
  {
    return Sys.getLicenseManager().getFeature("?? vendor", "?? feature");
  }
  */

  @Override
  public void changed(Property p, Context cx)
  {
    super.changed(p, cx);
    if(!isRunning()) return;

    if(p == status)
    {
      // Give any comms opportunity to respond to status changes
      getHttpConfig().statusUpdate();

    }
  }




////////////////////////////////////////////////////////////////
//Utilities
////////////////////////////////////////////////////////////////

  /** Access the http comm stack */
  public HttpComm hcomm()
  {
    return (HttpComm)getHttpConfig().comm();
  }





  public static Lexicon LEX = Lexicon.make(BNovantNetwork.class);

}
