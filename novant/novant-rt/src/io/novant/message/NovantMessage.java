//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package io.novant.message;

import java.io.*;

import com.tridium.ndriver.comm.*;
//import com.tridium.ndriver.io.*;
import com.tridium.ndriver.datatypes.*;
import com.tridium.ndriver.io.TypedInputStream;

/**
 *  NovantMessage is super class for all novant messages
 *
 *  @author   Novant LLC
 *  @creation 13-May-21
 */
public class NovantMessage
  extends NMessage
{


  public NovantMessage (BAddress address)
  {
    super(address);
  }


  // Override for outgoing messages
//  public boolean toOutputStream(OutputStream out)
//    throws Exception
//  {
//    // Use typed stream for more readable code.
//    TypedOutputStream to = new TypedOutputStream();
//
//    to.toOutputStream(out);
//    return false;
//  }

  //   Override for incoming messages
//  public void fromInputStream(InputStream in)
//    throws Exception
//  {
//    // Use typed stream for more readable code.
//    // Note: messageFactory must have created TypedInputStream
//    TypedInputStream ti = (TypedInputStream)in;
//  }

  //   Typical overrides
//  public Object getTag() { return nullTag; }
//  public boolean isResponse() { return false; }
//  public boolean isFragmentable() { return false; }
//  public int getResponseTimeOut() { return 2500; }

//  public String toTraceString()
//  {
//    return "??";
//  }

}
