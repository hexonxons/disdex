package com.hexonxons.dex.reader.data;

/**
 * Bitfields of these class flags are used to indicate the accessibility and overall properties of classes and class members.
 */
public class AccessFlags
{
    /**
     * For Classes (and InnerClass annotations): public: visible everywhere <br/>
     * For Fields: public: visible everywhere <br/>
     * For Methods: public: visible everywhere <br/>
     */
    public static final int ACC_PUBLIC                  = 0x01;

    /**
     * For Classes (and InnerClass annotations): private: only visible to defining class <br/>
     * Only allowed on for InnerClass annotations, and must not ever be on in a {@link com.hexonxons.dex.reader.data.ClassDefItem}. <br/>
     * For Fields: private: only visible to defining class <br/>
     * For Methods: private: only visible to defining class <br/>
     */
    public static final int ACC_PRIVATE                 = 0x02;

    /**
     * For Classes (and InnerClass annotations): protected: visible to package and subclasses <br/>
     * Only allowed on for InnerClass annotations, and must not ever be on in a {@link com.hexonxons.dex.reader.data.ClassDefItem}. <br/>
     * For Fields: protected: visible to package and subclasses <br/>
     * For Methods: protected: visible to package and subclasses <br/>
     */
    public static final int ACC_PROTECTED               = 0x04;

    /**
     * For Classes (and InnerClass annotations): static: is not constructed with an outer this reference <br/>
     * Only allowed on for InnerClass annotations, and must not ever be on in a {@link com.hexonxons.dex.reader.data.ClassDefItem}. <br/>
     * For Fields: static: global to defining class <br/>
     * For Methods: static: does not take a this argument <br/>
     */
    public static final int ACC_STATIC                  = 0x08;

    /**
     * For Classes (and InnerClass annotations): final: not subclassable <br/>
     * For Fields: final: immutable after construction <br/>
     * For Methods: final: not overridable <br/>
     */
    public static final int ACC_FINAL                   = 0x10;

    /**
     * For Methods: synchronized: associated lock automatically acquired around call to this method. Note: This is only valid to set when {@link #ACC_NATIVE} is also set. <br/>
     */
    public static final int ACC_SYNCHRONIZED            = 0x20;

    /**
     * For Fields: volatile: special access rules to help with thread safety <br/>
     */
    public static final int ACC_VOLATILE                = 0x40;

    /**
     * For Methods: bridge method, added automatically by compiler as a type-safe bridge <br/>
     */
    public static final int ACC_BRIDGE                  = 0x40;

    /**
     * For Fields: transient: not to be saved by default serialization <br/>
     */
    public static final int ACC_TRANSIENT               = 0x80;

    /**
     * For Methods: last argument should be treated as a "rest" argument by compiler <br/>
     */
    public static final int ACC_VARARGS                 = 0x80;

    /**
     * For Methods: native: implemented in native code <br/>
     */
    public static final int ACC_NATIVE                  = 0x100;

    /**
     * For Classes (and InnerClass annotations): interface: multiply-implementable abstract class <br/>
     */
    public static final int ACC_INTERFACE               = 0x200;

    /**
     * For Classes (and InnerClass annotations): abstract: not directly instantiable <br/>
     * For Methods: abstract: unimplemented by this class <br/>
     */
    public static final int ACC_ABSTRACT                = 0x400;

    /**
     * For Methods: strictfp: strict rules for floating-point arithmetic <br/>
     */
    public static final int ACC_STRICT                  = 0x800;

    /**
     * For Classes (and InnerClass annotations): not directly defined in source code <br/>
     * For Fields: not directly defined in source code <br/>
     * For Methods: not directly defined in source code <br/>
     */
    public static final int ACC_SYNTHETIC               = 0x1000;

    /**
     * For Classes (and InnerClass annotations): declared as an annotation class <br/>
     */
    public static final int ACC_ANNOTATION              = 0x2000;

    /**
     * For Classes (and InnerClass annotations): declared as an enumerated type <br/>
     * For Fields: declared as an enumerated value <br/>
     */
    public static final int ACC_ENUM                    = 0x4000;

    /**
     * Unused value. <br/>
     */
    public static final int ACC_UNUSED                  = 0x8000;

    /**
     * For Methods: constructor method (class or instance initializer) <br/>
     */
    public static final int ACC_CONSTRUCTOR             = 0x10000;

    /**
     * For Methods: declared synchronized. Note: This has no effect on execution (other than in reflection of this flag, per se). <br/>
     */
    public static final int ACC_DECLARED_SYNCHRONIZED   = 0x20000;
}
