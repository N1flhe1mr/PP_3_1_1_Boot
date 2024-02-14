FROM postgres:latest

WORKDIR /var/lib/postgresql/data
ENV POSTGRES_PASSWORD=postgrespassword
EXPOSE 5432
CMD ["postgres"]