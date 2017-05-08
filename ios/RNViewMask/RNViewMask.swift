import UIKit

@objc(RNViewMask)
class RNViewMask: UIView {
    
    private var _maskName: String = ""
    
    private var borderLayer = CAShapeLayer()
    
    var maskName: NSString? {
        set {
            if let name = newValue {
                if self._maskName != RCTConvert.nsString(name) {
                    self._maskName = RCTConvert.nsString(name)
                    self.setNeedsDisplay()
                }
            }
        }
        get {
            return nil
        }
    }
    
    override func draw(_ rect: CGRect) {
        super.draw(rect)
        setupViewMask(view: self)
    }
    
    override func layoutSubviews() {
        super.layoutSubviews()
        self.backgroundColor = UIColor.clear
        setupViewMask(view: self)
    }
    
    func setupViewMask(view: UIView) {
        if let maskImage = UIImage(named: self._maskName) {
          let maskView = UIImageView(image: maskImage)
          maskView.frame = view.frame
          maskView.contentMode = .scaleAspectFit
          
          view.mask = maskView
        }
    }
    
    override class var layerClass: AnyClass {
        return CAShapeLayer.self
    }
}
