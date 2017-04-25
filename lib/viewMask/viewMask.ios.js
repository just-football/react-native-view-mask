import React, { PropTypes } from 'react';
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

JFViewMask.propTypes = {
    ...View.propTypes,
    props: PropTypes.any,
    size: PropTypes.number.isRequired,
    isHorizontal: PropTypes.bool,
};

JFViewMask.defaultProps = {
    isHorizontal: false,
};

const RNJFViewMask = requireNativeComponent('RNViewMask', JFViewMask);
