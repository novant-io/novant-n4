//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package io.novant.point;

import javax.baja.control.BBooleanPoint;
import javax.baja.control.BBooleanWritable;
import javax.baja.control.BControlPoint;
import javax.baja.control.BEnumPoint;
import javax.baja.control.BEnumWritable;
import javax.baja.control.BNumericPoint;
import javax.baja.control.BNumericWritable;
import javax.baja.control.BStringPoint;
import javax.baja.control.BStringWritable;
import javax.baja.registry.TypeInfo;
import javax.baja.status.BStatusBoolean;
import javax.baja.status.BStatusEnum;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusString;
import javax.baja.status.BStatusValue;
import javax.baja.sys.BComponent;
import javax.baja.sys.BEnum;
import javax.baja.sys.BFacets;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.nre.util.Array;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.discover.BNPointDiscoveryLeaf;
import com.tridium.ndriver.util.SfUtil;

/**
 * BNovantPointDiscoveryLeaf is container class for point elements to
 * display in point discovery pane and pass to new point callback.
 */
@NiagaraType
@NiagaraProperty(
  name = "statusValue",
  type = "BStatusValue",
  defaultValue = "new BStatusNumeric()",
  flags = Flags.READONLY)
@NiagaraProperty(
  name = "facets",
  type = "BFacets",
  defaultValue = "BFacets.DEFAULT",
  flags = Flags.READONLY,
  facets = { @Facet(name="SfUtil.KEY_MGR", value="SfUtil.MGR_UNSEEN")})
public class BNovantPointDiscoveryLeaf
    extends BNPointDiscoveryLeaf
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/

////////////////////////////////////////////////////////////////
// Property "statusValue"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the <code>statusValue</code> property.
   */
  public static final Property statusValue = newProperty(Flags.READONLY, new BStatusNumeric(),null);

  /**
   * Get the <code>statusValue</code> property.
   */
  public BStatusValue getStatusValue() { return (BStatusValue)get(statusValue); }

  /**
   * Set the <code>statusValue</code> property.
   */
  public void setStatusValue(BStatusValue v) { set(statusValue,v,null); }

////////////////////////////////////////////////////////////////
// Property "facets"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the <code>facets</code> property.
   */
  public static final Property facets = newProperty(Flags.READONLY, BFacets.DEFAULT,SfUtil.incl(SfUtil.MGR_UNSEEN));

  /**
   * Get the <code>facets</code> property.
   */
  public BFacets getFacets() { return (BFacets)get(facets); }

  /**
   * Set the <code>facets</code> property.
   */
  public void setFacets(BFacets v) { set(facets,v,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNovantPointDiscoveryLeaf.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public BNovantPointDiscoveryLeaf() {}

  /* Return TypeInfo for valid new objects - match proxy type to statusValue type. */
  public TypeInfo[] getValidDatabaseTypes()
  {
    Array a = new Array(TypeInfo.class);
    BStatusValue sv = getStatusValue();

    //
    // TODO determine valid types for this leaf
    //

//    if(sv instanceof BStatusNumeric)
//    {
      a.add(BNumericPoint.TYPE.getTypeInfo());
//      if(writable) a.add(BNumericWritable.TYPE.getTypeInfo());
//    }
//    if(sv instanceof BStatusBoolean)
//    {
//      a.add(BBooleanPoint.TYPE.getTypeInfo());
//      if(writable) a.add(BBooleanWritable.TYPE.getTypeInfo());
//    }
//    if(sv instanceof BStatusString)
//    {
//      a.add(BStringPoint.TYPE.getTypeInfo());
//      if(writable) a.add(BStringWritable.TYPE.getTypeInfo());
//    }
//    if(sv instanceof BStatusEnum)
//    {
//      a.add(BEnumPoint.TYPE.getTypeInfo());
//      if(writable) a.add(BEnumWritable.TYPE.getTypeInfo());
//    }

    return (TypeInfo[])a.trim();
  }

  /* Call when adding new object based on this discovery leaf.  Initialize proxy. */
  public void updateTarget(BComponent target)
  {
    BControlPoint cp = (BControlPoint)target;
    BNovantProxyExt pext = new BNovantProxyExt();

    //
    // TODO - initialize values in new point
    //

    cp.setFacets(getFacets());
    cp.setProxyExt(pext);

    cp.getStatusValue().setValueValue(getStatusValue().getValueValue());
  }

  /**
   * Return true if the specified component is an existing representation
   * of this discovery object.
   */
  public boolean isExisting(BComponent target)
  {
    if(!(target instanceof BControlPoint)) return false;
    BControlPoint cp = (BControlPoint)target;
    BNovantProxyExt pext = (BNovantProxyExt)cp.getProxyExt();
    //
    // TODO - return true if specified component represents this leaf
    //

    return false;
  }
}