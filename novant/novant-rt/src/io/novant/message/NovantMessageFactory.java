//
// Copyright (c) 2021, Novant LLC
// Licensed under the MIT License
//
// History:
//   13 May 2021  Andy Frank  Creation
//

package io.novant.message;

import com.tridium.ndriver.comm.*;


/**
 * NovantMessageFactory implementation of IMessageFactory.
 *
 * @author   Novant LLC
 * @creation 13-May-21
 */
public class NovantMessageFactory
  implements IMessageFactory
{

  public NovantMessageFactory() {}

  public NMessage makeMessage(LinkMessage lm)
      throws Exception
  {
    //
    // TODO - convert linkMessage driver specific NMessage
    return null;
  }

}
