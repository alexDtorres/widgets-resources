const webpack = require("webpack");
const path = require("path");
const CopyWebpackPlugin = require("copy-webpack-plugin");
const ExtractTextPlugin = require("extract-text-webpack-plugin");

module.exports = {
    entry: "./src/components/BooleanSliderContainer.ts",
    output: {
        path: path.resolve(__dirname, "dist/tmp"),
        filename: "src/com/mendix/widget/custom/booleanslider/BooleanSlider.js",
        libraryTarget:  "umd"
    },
    resolve: {
        extensions: [ ".ts", ".js", ".json" ]
    },
    module: {
        rules: [
            { test: /\.ts$/, use: "ts-loader" },
            { test: /\.css$/, loader: ExtractTextPlugin.extract({
                fallback: "style-loader",
                use: "css-loader"
            }) },
            { test: /\.sass$/, loader: ExtractTextPlugin.extract({
                fallback:"style-loader",
                use: "css-loader!sass-loader"}
            ) }
        ]
    },
    devtool: "source-map",
    externals: [ "react", "react-dom" ],
    plugins: [
        new CopyWebpackPlugin([ { from: "src/**/*.xml" } ], { copyUnmodified: true }),
        new ExtractTextPlugin({ filename: "./src/com/mendix/widget/custom/booleanslider/ui/BooleanSlider.css" }),
        new webpack.LoaderOptionsPlugin({ debug: true })
    ]
};