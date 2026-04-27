public enum VolumeUnit implements IMeasurable {

    LITRE {
        public double toBase(double value) { return value * 1000; }
        public double fromBase(double baseValue) { return baseValue / 1000; }
    },

    MILLILITRE {
        public double toBase(double value) { return value; }
        public double fromBase(double baseValue) { return baseValue; }
    };
}