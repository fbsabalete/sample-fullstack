FROM node:20 AS base
WORKDIR /app

COPY package*.json ./

RUN ["npm", "ci"]

COPY . .


FROM base AS snapshot
CMD ["npm", "run", "dev"]


FROM base AS prod
RUN ["npm", "run", "build"]
EXPOSE 3000
CMD ["npm", "run", "start"]