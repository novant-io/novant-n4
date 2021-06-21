# Novant Driver for Niagara N4

The Novant Driver provides integration for [Novant](https://novant.io)
device data into Niagara N4.

It currently supports:

  * Discovery for device points
  * Reading live values

## Installing

[rel]: https://github.com/novant-io/novant-n4/releases/tag/0.3

To install the Novant Driver on N4:

  * Download the latest `novant-rt.jar`: [Version 0.3][rel]
  * Move `novant-rt.jar` into the `modules/` folder for N4 instance(s)
  * Restart your station and Workbench instance
  * Drag `NovantNetwork` from the `novant` palette into `Config` > `Drivers`

## Using

To add a new Novant device:

  * Navigate to the `NovantNetwork` in Workbench
  * Click `New` to add device
  * Enter `Name`, `Device Id` and `Api Key`

To discover points:

  * Navigate to a `NovantDevice` under the `NovantNetwork`
  * Click `Discover`
  * Discovered points will appear in discovery manager table, which can then
    be added to your station

To manually add a point:

  * Navigate the a `NovantDevice` under the `NovantNetwork`
  * Click `New` to add a point
  * Enter `Name`, `Point Id` and select the point type (`Numeric` or `Boolean`)