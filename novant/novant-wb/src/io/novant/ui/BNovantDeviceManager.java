//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   3 Jun 2021  Andy Frank  Creation
//

package io.novant.ui;

import javax.baja.sys.*;
import javax.baja.util.*;
import javax.baja.gx.*;
import javax.baja.ui.*;
import javax.baja.job.*;
import javax.baja.driver.*;
import javax.baja.driver.ui.device.*;
import javax.baja.workbench.mgr.*;
import javax.baja.workbench.mgr.folder.*;
import javax.baja.nre.annotations.*;

import com.tridium.util.ArrayUtil;
import io.novant.*;
// import io.novant.learn.*;

/**
 * BNovantDeviceManager provides the user interface to manage
 * sample devices on a single network.
 */
@NiagaraType
public class BNovantDeviceManager
  extends BDeviceManager
{ 
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNovantDeviceManager.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Constructor
////////////////////////////////////////////////////////////////

  public BNovantDeviceManager()
  {
  }

  /**
   * Gets ancestor network object.
   */
  public BNovantNetwork getNetwork()
  {
    BObject owner = getCurrentValue();
    if (owner instanceof BNovantDeviceFolder)
      return (BNovantNetwork)((BNovantDeviceFolder)owner).getNetwork();
    else if (owner instanceof BNovantNetwork)
      return (BNovantNetwork)owner;
    else
      return null;
  }

  public void doLoadValue(BObject obj, Context cx)
  {
     super.doLoadValue(obj,cx);
     // Sets the discovery data from the pan table entries
     updateLearnData();
  }

  /**
   * This method is called by the doLoadValue method and when the learn job completes.
   */
  void updateLearnData()
  {
    // BNovantLearnDevicesJob learnJob = (BNovantLearnDevicesJob)getLearn().getJob();
    // if(learnJob != null)
    //   getLearn().updateRoots(learnJob.getLearnedDevices().getChildren(BNovantLearnDeviceEntry.class) );
  }

  public BNovantDevice[] getSelectedDevices()
  {
    if (getModel() == null || getModel().getTable() == null)
    {
      return new BNovantDevice[0];
    }
    else
    {
      BComponent[] selection = getModel().getTable().getSelectedComponents();
      BNovantDevice[] devices = new BNovantDevice[0];
      for (int i=0; i<selection.length; i++)
        if (selection[i].getType().is(BNovantDevice.TYPE))
          devices = ArrayUtil.addOne(devices,(BNovantDevice)selection[i]);
      return devices;
    }
  }

////////////////////////////////////////////////////////////////
// Support
////////////////////////////////////////////////////////////////

  protected MgrModel makeModel() { return new Model(this); }
  protected MgrController makeController() { return new Controller(this); }
  protected MgrLearn makeLearn() { return new Learn(this); }
                                        
////////////////////////////////////////////////////////////////
// Model
////////////////////////////////////////////////////////////////
  
  class Model extends DeviceModel
  {
    Model(BDeviceManager manager) { super(manager); }
    
    protected MgrColumn[] makeColumns()
    {        
      return cols;   
    }                                   
  }                                 
                               
/////////////////////////////////////////////////////////////
// Learn
//////////////////////////////////////////////////////////////
  
  /**
   * Override of base learn support object
   */
  class Learn
    extends MgrLearn
  {
    Learn(BDeviceManager manager) { super(manager); }

    /**
     * This is method is called to initialize the 
     * columns used for the discovery table.
     */
    protected MgrColumn[] makeColumns()
    {
      return new MgrColumn[]{
          //
          // TODO - add discovery column entries
          //
      };
    }

    public BImage getIcon(Object dis)
    {
      return stationIcon;
    }

    public MgrTypeInfo[] toTypes(Object discovery)
    {
      return MgrTypeInfo.makeArray( getNetwork().getDeviceType());
    }

    public void toRow(Object discovery, MgrEditRow row)
    {
      // BNovantLearnDeviceEntry learnEntry = (BNovantLearnDeviceEntry)discovery;
      //
      // TODO - add code to make changes to row based on discovery object
      //
    }
    
    /**
     * Allows the core to ask us if a discovered item is equivalent
     * to a given pre-existing item.
     */
    public boolean isExisting(Object dis, BComponent comp)
    {
      // BNovantLearnDeviceEntry learnEntry = (BNovantLearnDeviceEntry)dis;
      // BNovantDevice d = (BNovantDevice)comp;
      
      //
      // TODO - add code to check if learnEntry is for specified device
      //
      
      return false;
    }
    
    /**
     * This callback is automatically invoked when the
     * current job set via <code>setJob()</code> completes.
     */
    public void jobComplete(BJob job)
    {
      super.jobComplete(job);
      // if (job instanceof BNovantLearnDevicesJob)
      // {
      //   updateLearnData();
      // }
    }
  }

////////////////////////////////////////////////////////////////
// Controller
////////////////////////////////////////////////////////////////

  class Controller extends DeviceController
  {             
    Controller(BDeviceManager mgr) { super(mgr); }
  }                 
                         
////////////////////////////////////////////////////////////////
// Attributes
////////////////////////////////////////////////////////////////

  static Lexicon lex = Lexicon.make(BNovantDeviceManager.class);
  static BImage stationIcon = BImage.make("module://icons/x16/device.png");
  
  // base class columns
  MgrColumn colName         = new MgrColumn.Name();
  MgrColumn colType         = new MgrColumn.Type();
  MgrColumn colDeviceExts   = new DeviceExtsColumn(new BNovantDevice());
  MgrColumn colStatus       = new MgrColumn.Prop(BDevice.status);
  MgrColumn colEnabled      = new MgrColumn.Prop(BDevice.enabled, MgrColumn.EDITABLE | MgrColumn.UNSEEN);
  MgrColumn colHealth       = new MgrColumn.Prop(BDevice.health, 0);
  
  // NovantDevice specific columns
  // TODO - add custom colums definitions and include in cols[]
  
  MgrColumn[] cols = 
  { 
    colName, colType, colDeviceExts,
    colStatus, colEnabled, colHealth,
  };
}
