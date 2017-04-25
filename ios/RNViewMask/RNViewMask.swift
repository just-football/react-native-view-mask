import UIKit

@objc(RNViewMask)
class RNViewMask: UIView {
    
    private var _maskName: NSString = false
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
    
    var maskName: NSString? {
        set {
            if let name = newValue {
                if self._maskName != RCTConvert.string(name) {
                    self._maskName = RCTConvert.string(name)
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
        if let maskImage = UIImage(named: this._maskName) {
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
