import * as React from 'react';
import { View, requireNativeComponent } from 'react-native';

export const JFViewMask = ({
	children,
	size,
	isHorizontal,
	...props
}) => (
	<RNJFViewMask
		{...props}
		isHorizontal={isHorizontal}
		size={size}
		>
		{children}
	</RNJFViewMask>
);


JFViewMask.defaultProps = {
	isHorizontal: false,
};

const RNJFViewMask = requireNativeComponent('RNJFViewMask', JFViewMask);
