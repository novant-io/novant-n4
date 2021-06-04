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
import javax.baja.control.*;
import javax.baja.driver.*;
import javax.baja.driver.point.*;
import javax.baja.driver.ui.point.*;
import javax.baja.workbench.mgr.*;
import javax.baja.workbench.mgr.folder.*;
import javax.baja.nre.annotations.*;
import io.novant.*;
import io.novant.point.*;

/**
 * BNovantPointManager provides the user interface to manage
 * proxy points in single device
 */
@NiagaraType
public class BNovantPointManager
  extends BPointManager
{                
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNovantPointManager.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Constructor
////////////////////////////////////////////////////////////////

  public BNovantPointManager()
  {
  }
  
////////////////////////////////////////////////////////////////
// Support
////////////////////////////////////////////////////////////////

  protected MgrModel makeModel() { return new Model(this); }
  protected MgrController makeController() { return new Controller(this); }
                                        
////////////////////////////////////////////////////////////////
// Model
////////////////////////////////////////////////////////////////
  
  class Model extends PointModel
  {
    Model(BPointManager manager) { super(manager); }
    
    protected MgrColumn[] makeColumns()
    {        
      return cols;   
    }                                   
  }                                 
                               
////////////////////////////////////////////////////////////////
// Controller
////////////////////////////////////////////////////////////////

  class Controller extends PointController
  {             
    Controller(BPointManager mgr) { super(mgr); }
  }                 
                         
////////////////////////////////////////////////////////////////
// Attributes
////////////////////////////////////////////////////////////////

  static Lexicon lex = Lexicon.make(BNovantPointManager.class);
  
  // base class columns
  MgrColumn colPath        = new MgrColumn.Path(MgrColumn.UNSEEN);
  MgrColumn colName        = new MgrColumn.Name();
  MgrColumn colType        = new MgrColumn.Type();
  MgrColumn colToString    = new MgrColumn.ToString("Out", 0);
  MgrColumn colEnabled     = new MgrColumn.PropPath(new Property[] {BControlPoint.proxyExt, BProxyExt.enabled}, MgrColumn.EDITABLE | MgrColumn.UNSEEN);
  MgrColumn colFacets      = new MgrColumn.PropPath(new Property[] {BControlPoint.facets},  MgrColumn.EDITABLE | MgrColumn.UNSEEN);
  MgrColumn colTuning      = new MgrColumn.PropPath(new Property[] {BControlPoint.proxyExt, BProxyExt.tuningPolicyName}, MgrColumn.EDITABLE);
  MgrColumn colDeviceFacets= new MgrColumn.PropPath(new Property[] {BControlPoint.proxyExt, BProxyExt.deviceFacets}, MgrColumn.EDITABLE | MgrColumn.UNSEEN);
  MgrColumn colConversion  = new MgrColumn.PropPath(new Property[] {BControlPoint.proxyExt, BProxyExt.conversion},   MgrColumn.EDITABLE | MgrColumn.UNSEEN);
  MgrColumn colFaultCause  = new MgrColumn.PropPath(new Property[] {BControlPoint.proxyExt, BProxyExt.faultCause},   MgrColumn.UNSEEN);
  MgrColumn colReadValue   = new MgrColumn.PropPath(new Property[] {BControlPoint.proxyExt, BProxyExt.readValue},    MgrColumn.UNSEEN);
  MgrColumn colWriteValue  = new MgrColumn.PropPath(new Property[] {BControlPoint.proxyExt, BProxyExt.writeValue},   MgrColumn.UNSEEN);
  
  // NovantProxyExt specific columns
  MgrColumn[] cols = 
  { 
    colPath, colName, colType, colToString,
    colEnabled, colFacets, colTuning, colDeviceFacets, colConversion,
    colFaultCause, colReadValue, colWriteValue,
  };
}
