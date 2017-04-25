import UIKit

@objc(RNViewMask)
class RNViewMask: UIView {
    
    private var _isHorizontal: Bool = false
    private var _size: CGFloat = 0
    
    private var borderLayer = CAShapeLayer()
    
    var size: NSNumber? {
        set {
            let newSize = RCTConvert.cgFloat(newValue)
            self.frame.size.width = newSize
            self.frame.size.height = newSize
            self.setNeedsDisplay()
        }
        get {
            return nil
        }
    }
    
    var isHorizontal: NSNumber? {
        set {
            if let horizontal = newValue {
                if self._isHorizontal != RCTConvert.bool(horizontal) {
                    self._isHorizontal = RCTConvert.bool(horizontal)
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
        if let maskImage = UIImage(named: "mask") {
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
