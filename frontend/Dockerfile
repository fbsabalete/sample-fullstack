FROM node:20 AS base
WORKDIR /app
COPY package*.json ./
COPY . .
RUN ["npm", "ci"]


FROM base AS snapshot
CMD ["npm", "run", "dev"]


FROM base AS prod
ENV CI=true
RUN ["npm", "run", "build"]
EXPOSE 3000
CMD ["npm", "run", "start"]