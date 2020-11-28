package require_issue;

import clojure.lang.RT;
import clojure.lang.IFn;
import static clojure.lang.Compiler.eval;

public class FromJava0 {

    private static final String namespace = "require-issue.core";

    static {
        eval(RT.readString("(require '" + namespace + ")"));
    }

    public static Object readJson(String json) {
        IFn fn = getClojureFn("require-issue.core", "json-read-string");
        return fn.invoke(json);
    }

    private static IFn getClojureFn(String namespace, String name) {
        return (IFn) RT.var(namespace, name).deref();
    }
}
