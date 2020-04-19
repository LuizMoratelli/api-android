package br.com.luizmoratelli.api_android.model;

import com.google.gson.annotations.SerializedName;

public class CensosResponse {
    @SerializedName("_embedded")
    private final Embedded embedded;

    @SerializedName("_links")
    private final Links links;

    public CensosResponse(Embedded embedded, Links links) {
        this.embedded = embedded;
        this.links = links;
    }

    public Embedded getEmbedded() {
        return embedded;
    }

    public Links getLinks() {
        return links;
    }

}
