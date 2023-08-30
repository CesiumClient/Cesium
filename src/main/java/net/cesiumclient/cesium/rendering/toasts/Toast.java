package net.cesiumclient.cesium.rendering.toasts;

public class Toast {
    private String message;
    private long displayStartTime;
    private long displayDuration;
    private float x;
    private float y;

    public Toast(String message, long displayDuration) {
        this.message = message;
        this.displayDuration = displayDuration;
        this.displayStartTime = System.currentTimeMillis();
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String getMessage() {
        return message;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - displayStartTime >= displayDuration;
    }
}
