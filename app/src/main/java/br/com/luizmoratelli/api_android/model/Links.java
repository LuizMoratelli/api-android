package br.com.luizmoratelli.api_android.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Links implements Serializable {
    @SerializedName("self")
    private final Self self;

    public Links(Self self) {
        this.self = self;
    }

    public Self getSelf() {
        return self;
    }

    public static class Self implements Serializable {
        @SerializedName("href")
        private final String href;

        public Self(String href) {
            this.href = href;
        }

        public String getHref() {
            return href;
        }
    }
}
