package br.com.luizmoratelli.api_android.model;

import com.google.gson.annotations.SerializedName;

public class Censos {
    @SerializedName("coletor")
    private final int coletor;

    @SerializedName("dados")
    private final String dados;

    @SerializedName("_links")
    private final Links links;

    public Censos(int coletor, String dados, Links links) {
        this.coletor = coletor;
        this.dados = dados;
        this.links = links;
    }

    public int getColetor() {
        return coletor;
    }

    public String getDados() {
        return dados;
    }

    public Links getLinks() {
        return links;
    }

    public static class Links {
        @SerializedName("self")
        private final Links.Self self;

        @SerializedName("censo")
        private final Links.Censo censo;

        public Links(Links.Self self, Links.Censo censo) {
            this.self = self;
            this.censo = censo;
        }

        public Links.Self getSelf() {
            return self;
        }

        public Links.Censo getCenso() {
            return censo;
        }

        public static class Self {
            @SerializedName("href")
            private final String href;

            public Self(String href) {
                this.href = href;
            }

            public String getHref() {
                return href;
            }
        }

        public static class Censo {
            @SerializedName("href")
            private final String href;

            public Censo(String href) {
                this.href = href;
            }

            public String getHref() {
                return href;
            }
        }
    }
}
