FROM node:20 AS base
WORKDIR /app
COPY package*.json ./
COPY . .


FROM base AS development
RUN ["npm", "install"]
CMD ["npm", "run", "dev"]


FROM base AS production
RUN ["npm", "run", "build"]
EXPOSE 3000
CMD ["npm", "run", "start"]