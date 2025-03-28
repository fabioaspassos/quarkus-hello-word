FROM eclipse-temurin:21-jre-alpine

WORKDIR /deployments/
# Copiamos o jar da aplicação
COPY target/quarkus-app/quarkus-run.jar /deployments/app.jar
COPY target/quarkus-app/lib/ /deployments/lib/
COPY target/quarkus-app/app/ /deployments/app/
COPY target/quarkus-app/quarkus/ /deployments/quarkus/

# Importante: variável de ambiente para o port
ENV QUARKUS_HTTP_PORT=8080

# Importante: Expor a porta
EXPOSE 8080

# Opcional: Adicione um health check no Dockerfile
HEALTHCHECK --interval=5s --timeout=3s --start-period=30s --retries=3 CMD curl -f http://localhost:8080/q/health || exit 1

# Comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]