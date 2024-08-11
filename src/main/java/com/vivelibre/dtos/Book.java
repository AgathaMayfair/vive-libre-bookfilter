package com.vivelibre.dtos;

public class Book {

    private int id;

    private String title;

    private String summary;

    private int pages;

    private String publicationTimestamp;

    private Author author;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public int getPages() {
        return pages;
    }

    public String getPublicationTimestamp() {
        return publicationTimestamp;
    }

    public Author getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPublicationTimestamp(String publicationTimestamp) {
        this.publicationTimestamp = publicationTimestamp;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", pages=" + pages +
                ", publicationTimestamp='" + publicationTimestamp + '\'' +
                ", author=" + author +
                '}';
    }

    public class Author {

        private String name;

        private String firstSurname;

        private String bio;

        public String getName() {
            return name;
        }

        public String getFirstSurname() {
            return firstSurname;
        }

        public String getBio() {
            return bio;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setFirstSurname(String firstSurname) {
            this.firstSurname = firstSurname;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        @Override
        public String toString() {
            return "Author{" +
                    "name='" + name + '\'' +
                    ", firstSurname='" + firstSurname + '\'' +
                    ", bio='" + bio + '\'' +
                    '}';
        }

    }

}