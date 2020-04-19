package br.com.luizmoratelli.api_android;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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

    public static class Embedded {
        @SerializedName("censos")
        private final List<Censos> censos;

        public Embedded(List<Censos> censos) {
            this.censos = censos;
        }

        public List<Censos> getCensos() {
            return censos;
        }

        public static class Censos {
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
                private final Self self;

                @SerializedName("censo")
                private final Censo censo;

                public Links(Self self, Censo censo) {
                    this.self = self;
                    this.censo = censo;
                }

                public Self getSelf() {
                    return self;
                }

                public Censo getCenso() {
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
    }

    public static class Links {
        @SerializedName("self")
        private final Self self;

        public Links(Self self) {
            this.self = self;
        }

        public Self getSelf() {
            return self;
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
    }
}
