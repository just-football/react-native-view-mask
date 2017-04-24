import UIKit

@objc(RNViewMaskManager)
class RNViewMaskManager: RCTViewManager {
  
  @objc override func view() -> UIView! {
    return RNViewMask()
  }
}
