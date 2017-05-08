#import <Foundation/Foundation.h>

#import "React/RCTBridgeModule.h"
#import "React/RCTViewManager.h"

@interface RCT_EXTERN_MODULE(RNViewMaskManager, RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(maskName, NSString)

@end
