//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package io.novant.point;

import java.util.*;

import javax.baja.control.*;
import javax.baja.nre.util.Array;
import javax.baja.nre.annotations.*;
import javax.baja.registry.TypeInfo;
import javax.baja.units.*;
import javax.baja.status.*;
import javax.baja.sys.*;

import com.tridium.ndriver.discover.BNPointDiscoveryLeaf;
import com.tridium.ndriver.util.SfUtil;

import io.novant.util.*;

/**
 * BNovantPointDiscoveryLeaf is container class for point elements to
 * display in point discovery pane and pass to new point callback.
 */
@NiagaraType
@NiagaraProperty(
  name = "pointId",
  type = "String",
  defaultValue = "",
  flags = Flags.READONLY,
  facets = @Facet("SfUtil.incl(SfUtil.MGR_EDIT)")
)
@NiagaraProperty(
  name = "pointName",
  type = "String",
  defaultValue = "",
  facets = @Facet("SfUtil.incl(SfUtil.MGR_EDIT)")
)
@NiagaraProperty(
  name = "kind",
  type = "String",
  defaultValue = "num",
  flags = Flags.READONLY,
  facets = @Facet("SfUtil.incl(SfUtil.MGR_EDIT)")
)
@NiagaraProperty(
  name = "writable",
  type = "boolean",
  defaultValue = "false",
  flags = Flags.READONLY,
  facets = @Facet("SfUtil.incl(SfUtil.MGR_EDIT)")
)
@NiagaraProperty(
  name = "unit",
  type = "String",
  defaultValue = "",
  facets = @Facet("SfUtil.incl(SfUtil.MGR_EDIT)")
)
public class BNovantPointDiscoveryLeaf extends BNPointDiscoveryLeaf
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $io.novant.point.BNovantPointDiscoveryLeaf(1017338950)1.0$ @*/
/* Generated Thu Jun 17 10:25:43 EDT 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "pointId"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the {@code pointId} property.
   * @see #getPointId
   * @see #setPointId
   */
  public static final Property pointId = newProperty(Flags.READONLY, "", SfUtil.incl(SfUtil.MGR_EDIT));

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
// Property "pointName"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the {@code pointName} property.
   * @see #getPointName
   * @see #setPointName
   */
  public static final Property pointName = newProperty(0, "", SfUtil.incl(SfUtil.MGR_EDIT));

  /**
   * Get the {@code pointName} property.
   * @see #pointName
   */
  public String getPointName() { return getString(pointName); }

  /**
   * Set the {@code pointName} property.
   * @see #pointName
   */
  public void setPointName(String v) { setString(pointName, v, null); }

////////////////////////////////////////////////////////////////
// Property "kind"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the {@code kind} property.
   * @see #getKind
   * @see #setKind
   */
  public static final Property kind = newProperty(Flags.READONLY, "num", SfUtil.incl(SfUtil.MGR_EDIT));

  /**
   * Get the {@code kind} property.
   * @see #kind
   */
  public String getKind() { return getString(kind); }

  /**
   * Set the {@code kind} property.
   * @see #kind
   */
  public void setKind(String v) { setString(kind, v, null); }

////////////////////////////////////////////////////////////////
// Property "writable"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the {@code writable} property.
   * @see #getWritable
   * @see #setWritable
   */
  public static final Property writable = newProperty(Flags.READONLY, false, SfUtil.incl(SfUtil.MGR_EDIT));

  /**
   * Get the {@code writable} property.
   * @see #writable
   */
  public boolean getWritable() { return getBoolean(writable); }

  /**
   * Set the {@code writable} property.
   * @see #writable
   */
  public void setWritable(boolean v) { setBoolean(writable, v, null); }

////////////////////////////////////////////////////////////////
// Property "unit"
////////////////////////////////////////////////////////////////

  /**
   * Slot for the {@code unit} property.
   * @see #getUnit
   * @see #setUnit
   */
  public static final Property unit = newProperty(0, "", SfUtil.incl(SfUtil.MGR_EDIT));

  /**
   * Get the {@code unit} property.
   * @see #unit
   */
  public String getUnit() { return getString(unit); }

  /**
   * Set the {@code unit} property.
   * @see #unit
   */
  public void setUnit(String v) { setString(unit, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNovantPointDiscoveryLeaf.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  /** Default ctor */
  public BNovantPointDiscoveryLeaf()
  {
    // TODO: this is not a valid ctor; should we throw?
    this.map = new HashMap();
  }

  /** Construct new object with API results */
  public BNovantPointDiscoveryLeaf(HashMap map)
  {
    String id     = (String)map.get("id");
    String name   = (String)map.get("name");
    String kind   = (String)map.get("kind");
    Boolean write = (Boolean)map.get("writable");
    String unit   = (String)map.get("unit");

    // sanity checks
    if (id    == null) throw new RuntimeException("Missing 'id'");
    if (name  == null) throw new RuntimeException("Missing 'name'");
    if (kind  == null) kind  = "num";
    if (write == null) write = Boolean.FALSE;
    if (unit  == null) unit  = "";

    this.setPointId(id);
    this.setPointName(name);
    this.setKind(kind);
    this.setWritable(write.booleanValue());
    this.setUnit(unit);
  }

  /**
   * Get the display name of this node.
   */
  public String getDiscoveryName()
  {
    return getPointName();
  }

  /**
   * Return TypeInfo for valid new objects.
   */
  public TypeInfo[] getValidDatabaseTypes()
  {
    Array acc = new Array(TypeInfo.class);
    String k = getKind();
    boolean w = getWritable();

    if (k.equals("bool"))
    {
      acc.add(BBooleanPoint.TYPE.getTypeInfo());
      if (w) acc.add(BBooleanWritable.TYPE.getTypeInfo());
    }
    else
    {
      acc.add(BNumericPoint.TYPE.getTypeInfo());
      if (w) acc.add(BNumericWritable.TYPE.getTypeInfo());
    }

    return (TypeInfo[])acc.trim();
  }

  /**
   * Callback to create new point based on discovery leaf.
   */
  public void updateTarget(BComponent target)
  {
    BControlPoint p = (BControlPoint)target;
    BFacets f = p.getFacets();
    BNovantProxyExt ext = new BNovantProxyExt();

    String unit = getUnit();
    if (unit.length() > 0) f = BFacets.make(f, "units", NovantUnits.get(unit));

    ext.setPointId(getPointId());
    p.setProxyExt(ext);
    p.setFacets(f);
  }

  /**
   * Return true if the given point is an existing representation
   * of this discovery object.
   */
  public boolean isExisting(BComponent target)
  {
    if (!(target instanceof BControlPoint)) return false;

    BControlPoint p = (BControlPoint)target;
    BNovantProxyExt ext = (BNovantProxyExt)p.getProxyExt();
    return ext.getPointId().equals(getPointId());
  }

  private HashMap map;
}