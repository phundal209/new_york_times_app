package example.pullrequest.com.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by phundal on 12/1/17.
 */

public class MediaResponse {

    @SerializedName("status")
    private String status;
    @SerializedName("copyright")
    private String copyright;
    @SerializedName("has_more")
    private boolean has_more;
    @SerializedName("num_results")
    private int num_results;
    @SerializedName("results")
    private List<Results> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public static class Link {
        @SerializedName("type")
        private String type;
        @SerializedName("url")
        private String url;
        @SerializedName("suggested_link_text")
        private String suggested_link_text;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSuggested_link_text() {
            return suggested_link_text;
        }

        public void setSuggested_link_text(String suggested_link_text) {
            this.suggested_link_text = suggested_link_text;
        }
    }

    public static class Multimedia {
        @SerializedName("type")
        private String type;
        @SerializedName("src")
        private String src;
        @SerializedName("width")
        private int width;
        @SerializedName("height")
        private int height;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public static class Results {
        @SerializedName("display_title")
        private String display_title;
        @SerializedName("mpaa_rating")
        private String mpaa_rating;
        @SerializedName("critics_pick")
        private int critics_pick;
        @SerializedName("byline")
        private String byline;
        @SerializedName("headline")
        private String headline;
        @SerializedName("summary_short")
        private String summary_short;
        @SerializedName("publication_date")
        private String publication_date;
        @SerializedName("opening_date")
        private String opening_date;
        @SerializedName("date_updated")
        private String date_updated;
        @SerializedName("link")
        private Link link;
        @SerializedName("multimedia")
        private Multimedia multimedia;

        public String getDisplay_title() {
            return display_title;
        }

        public void setDisplay_title(String display_title) {
            this.display_title = display_title;
        }

        public String getMpaa_rating() {
            return mpaa_rating;
        }

        public void setMpaa_rating(String mpaa_rating) {
            this.mpaa_rating = mpaa_rating;
        }

        public int getCritics_pick() {
            return critics_pick;
        }

        public void setCritics_pick(int critics_pick) {
            this.critics_pick = critics_pick;
        }

        public String getByline() {
            return byline;
        }

        public void setByline(String byline) {
            this.byline = byline;
        }

        public String getHeadline() {
            return headline;
        }

        public void setHeadline(String headline) {
            this.headline = headline;
        }

        public String getSummary_short() {
            return summary_short;
        }

        public void setSummary_short(String summary_short) {
            this.summary_short = summary_short;
        }

        public String getPublication_date() {
            return publication_date;
        }

        public void setPublication_date(String publication_date) {
            this.publication_date = publication_date;
        }

        public String getOpening_date() {
            return opening_date;
        }

        public void setOpening_date(String opening_date) {
            this.opening_date = opening_date;
        }

        public String getDate_updated() {
            return date_updated;
        }

        public void setDate_updated(String date_updated) {
            this.date_updated = date_updated;
        }

        public Link getLink() {
            return link;
        }

        public void setLink(Link link) {
            this.link = link;
        }

        public Multimedia getMultimedia() {
            return multimedia;
        }

        public void setMultimedia(Multimedia multimedia) {
            this.multimedia = multimedia;
        }
    }
}
