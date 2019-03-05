if (process.env.NODE_ENV === "production") {
    const opt = require("./diode-example-opt.js");
    opt.main();
    module.exports = opt;
} else {
    var exports = window;
    exports.require = require("./diode-example-fastopt-entrypoint.js").require;
    window.global = window;

    const fastOpt = require("./diode-example-fastopt.js");
    fastOpt.main()
    module.exports = fastOpt;

    if (module.hot) {
        module.hot.accept();
    }
}
