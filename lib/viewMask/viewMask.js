import React, { PropTypes } from 'react';
import { View, requireNativeComponent } from 'react-native';

export const JFViewMask = ({
    children,
    maskName,
    ...props
}) => (
    <RNJFViewMask
		{...props}
		maskName={maskName}
		>
		{children}
	</RNJFViewMask>
);

JFViewMask.propTypes = {
    ...View.propTypes,
    props: PropTypes.any,
    maskName: PropTypes.string,
};

JFViewMask.defaultProps = {
    maskName: "hexagon_vertical",
};

const RNJFViewMask = requireNativeComponent('RNViewMask', JFViewMask);
