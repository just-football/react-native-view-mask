import React, { PropTypes } from 'react';
import { View, requireNativeComponent } from 'react-native';

export const JFViewMask = ({
    children,
    size,
    maskName,
    ...props
}) => (
    <RNJFViewMask
		{...props}
		maskName={maskName}
		size={size}
		>
		{children}
	</RNJFViewMask>
);

JFViewMask.propTypes = {
    ...View.propTypes,
    props: PropTypes.any,
    size: PropTypes.number.isRequired,
    maskName: PropTypes.string,
};

JFViewMask.defaultProps = {
    maskName: "hexagon_vertical",
};

const RNJFViewMask = requireNativeComponent('RNViewMask', JFViewMask);
